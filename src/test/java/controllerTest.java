import com.xiaomiStore.pojo.IndexView;
import com.xiaomiStore.pojo.OriginType;
import com.xiaomiStore.pojo.Type;
import com.xiaomiStore.service.ProductService;
import com.xiaomiStore.service.TypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class controllerTest {
    @Autowired
    ProductService productService;
    @Autowired
    private TypeService typeService;

    @Test
    public void showTypeList() {
        IndexView view = new IndexView();
        List<Type> typeList = typeService.selectByParentId(String.valueOf(0));
        for (Type t : typeList) {
            OriginType originType = new OriginType();
            originType.setType(t);
            originType.setTypeList(typeService.selectByParentId(t.getTypeId()));
            originType.setProductList(productService.selectByTypeId(t.getTypeId()));
            view.getOriginTypeList().add(originType);
        }

        System.out.println(view);
    }
}
