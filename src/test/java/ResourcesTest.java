import com.xiaomiStore.pojo.Product;
import com.xiaomiStore.pojo.Type;
import com.xiaomiStore.service.ProductService;
import com.xiaomiStore.service.TypeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ResourcesTest {
    private static final String SAVEPATH = "D:\\Java\\xiaomiStore\\web\\WEB-INF\\static\\image\\thumb";
    @Autowired
    ProductService productService;
    @Autowired
    TypeService typeService;

    private static void download(String urlString, String filename) throws Exception {
        System.out.println("urlString = " + urlString);
        System.out.println("filename = " + filename);
        System.out.println("SAVEPATH = " + SAVEPATH);
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5 * 1000);
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf = new File(ResourcesTest.SAVEPATH);
        if (!sf.exists()) {
            sf.mkdirs();
        }
        OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        File file = new File(sf.getPath() + "\\" + filename);
        assert file.exists();
        // write to jpeg file
        String path = SAVEPATH + "\\" + filename.substring(0, filename.lastIndexOf('.')) + ".jpg";
        System.out.println("path = " + path);
        BufferedImage bufferedImage = ImageIO.read(file);
        // create a blank, RGB, same width and height, and a white background
        BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
                bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        //TYPE_INT_RGB:创建一个RBG图像，24位深度，成功将32位图转化成24位

        newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
        File newFile = new File(path);
        ImageIO.write(newBufferedImage, "jpg", newFile);
        System.out.println(newFile.exists());
//        System.out.println(file.delete());
        System.out.println("Done");
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

    @Test
    public void webtest() throws IOException {
        URL url;
        URLConnection con;
        InputStream is = null;
        OutputStream os = null;
        Document doc = Jsoup.parse(new File("D:\\Java\\xiaomiStore\\web\\1.html"), "UTF-8");
        Elements thumbList = doc.getElementsByClass("thumb");

        Elements categoryItemList = doc.getElementsByClass("category-item");
        int size = thumbList.size();
        int num = 0;
        for (int i = 0; i < categoryItemList.size(); i++) {
            Elements textList = categoryItemList.eq(i).select(".text");
            String typeName = categoryItemList.eq(i).select(".title").text().substring(
                    0, categoryItemList.eq(i).select(".title").text().length() - 1)
                    .replace(" ", "  ");
            System.out.println("typeName = " + typeName);
            Type t = typeService.selectByName(typeName);
            if (t == null) {
                System.out.println("null");
            } else {
                System.out.println(t.getTypeId());
            }
            for (Element element : textList) {
                num++;
                System.out.println("e = " + element.text());
                assert t != null;
                productService.insert(new Product(num + "", element.text(), "", t.getTypeId()));
            }
        }
    }

    @Test
    public void imageTest() throws Exception {
        BufferedImage bufferedImage = null;
        Document doc = Jsoup.parse(new File("D:\\Java\\xiaomiStore\\web\\1.html"), "UTF-8");
        Elements thumbList = doc.getElementsByClass("thumb");
        Elements textList = doc.getElementsByClass("text");
        assert thumbList.size() == textList.size();
        int size = thumbList.size();
        for (int i = 0; i < size; i++) {
            String typeName = textList.eq(i).text();
            System.out.println("originTypeName = " + typeName);
            typeName = typeName.replace(' ', '_').replace("\"", "");
            System.out.println("nowTypeName = " + typeName);
            String imgUrl = "https:" + thumbList.eq(i).attr("data-src");
            System.out.println("imgUrl = " + imgUrl);
            String imageType = imgUrl.substring(imgUrl.lastIndexOf('.'), imgUrl.indexOf('?'));
            System.out.println("imageType = " + imageType);
            String path = "D:\\Java\\xiaomiStore\\web\\WEB-INF\\static\\image\\thumb\\"
                    + typeName + imageType;
            System.out.println(" path = " + path);
            download(imgUrl, typeName + imageType);
        }
    }

}
