/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : xiaomi

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-06-21 19:00:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xiaomi_attention
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_attention`;
CREATE TABLE `xiaomi_attention` (
  `userId` varchar(255) NOT NULL DEFAULT '',
  `productId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_attention
-- ----------------------------

-- ----------------------------
-- Table structure for xiaomi_color
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_color`;
CREATE TABLE `xiaomi_color` (
  `colorId` varchar(30) NOT NULL DEFAULT '',
  `colorName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`colorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_color
-- ----------------------------
INSERT INTO `xiaomi_color` VALUES ('#000000', '黑色');
INSERT INTO `xiaomi_color` VALUES ('#0000FF', '蓝色');
INSERT INTO `xiaomi_color` VALUES ('#ffffff', '白色');

-- ----------------------------
-- Table structure for xiaomi_comment
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_comment`;
CREATE TABLE `xiaomi_comment` (
  `commentId` varchar(255) NOT NULL DEFAULT '',
  `userId` varchar(255) DEFAULT NULL,
  `productId` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_comment
-- ----------------------------

-- ----------------------------
-- Table structure for xiaomi_coupon
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_coupon`;
CREATE TABLE `xiaomi_coupon` (
  `couponId` varchar(255) NOT NULL DEFAULT '' COMMENT '优惠券',
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`couponId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_coupon
-- ----------------------------
INSERT INTO `xiaomi_coupon` VALUES ('1', 'aaaaaa', '1111', 'jsahdjashj', '1');
INSERT INTO `xiaomi_coupon` VALUES ('2', 'bbbbb', '12345', 'sdsaasd', '2');

-- ----------------------------
-- Table structure for xiaomi_order
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_order`;
CREATE TABLE `xiaomi_order` (
  `orderId` varchar(20) NOT NULL DEFAULT '' COMMENT '订单编号',
  `userId` varchar(20) NOT NULL DEFAULT '' COMMENT '用户编号',
  `sum` int(11) NOT NULL DEFAULT '0' COMMENT '总价',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_order
-- ----------------------------

-- ----------------------------
-- Table structure for xiaomi_product
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_product`;
CREATE TABLE `xiaomi_product` (
  `productId` varchar(20) NOT NULL DEFAULT '',
  `productName` varchar(255) NOT NULL DEFAULT '',
  `productDescription` varchar(255) NOT NULL DEFAULT '',
  `typeId` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_product
-- ----------------------------
INSERT INTO `xiaomi_product` VALUES ('1', '小米8', '', '1');
INSERT INTO `xiaomi_product` VALUES ('10', '红米5 Plus', '', '1');
INSERT INTO `xiaomi_product` VALUES ('100', '大方智能摄像机', '', '5');
INSERT INTO `xiaomi_product` VALUES ('101', '米家智能摄像机1080P', '', '5');
INSERT INTO `xiaomi_product` VALUES ('102', '小白智能摄像机大众版', '', '5');
INSERT INTO `xiaomi_product` VALUES ('103', '米家蓝牙温湿度计', '', '5');
INSERT INTO `xiaomi_product` VALUES ('104', '九号平衡车', '', '6');
INSERT INTO `xiaomi_product` VALUES ('105', '九号平衡车Plus', '', '6');
INSERT INTO `xiaomi_product` VALUES ('106', '米家电动滑板车', '', '6');
INSERT INTO `xiaomi_product` VALUES ('107', '电助力折叠自行车', '', '6');
INSERT INTO `xiaomi_product` VALUES ('108', '行车记录仪', '', '6');
INSERT INTO `xiaomi_product` VALUES ('109', '70迈智能后视镜', '', '6');
INSERT INTO `xiaomi_product` VALUES ('11', '红米5', '', '1');
INSERT INTO `xiaomi_product` VALUES ('110', '米兔遥控小飞机', '', '6');
INSERT INTO `xiaomi_product` VALUES ('111', '米兔儿童手表2', '', '6');
INSERT INTO `xiaomi_product` VALUES ('112', '米兔智能积木', '', '6');
INSERT INTO `xiaomi_product` VALUES ('113', '米兔故事机', '', '6');
INSERT INTO `xiaomi_product` VALUES ('114', '积木机器人', '', '6');
INSERT INTO `xiaomi_product` VALUES ('115', '米兔定位电话', '', '6');
INSERT INTO `xiaomi_product` VALUES ('116', '米兔轨道积木', '', '6');
INSERT INTO `xiaomi_product` VALUES ('117', '小米无人机', '', '6');
INSERT INTO `xiaomi_product` VALUES ('118', '米家对讲机', '', '6');
INSERT INTO `xiaomi_product` VALUES ('119', '米家小相机', '', '6');
INSERT INTO `xiaomi_product` VALUES ('12', '红米5A', '', '1');
INSERT INTO `xiaomi_product` VALUES ('120', '米家全景相机', '', '6');
INSERT INTO `xiaomi_product` VALUES ('121', '小蚁微单相机', '', '6');
INSERT INTO `xiaomi_product` VALUES ('122', '小米米家智能后视镜', '', '6');
INSERT INTO `xiaomi_product` VALUES ('123', '米兔儿童滑板车', '', '6');
INSERT INTO `xiaomi_product` VALUES ('124', '小米路由器4', '', '7');
INSERT INTO `xiaomi_product` VALUES ('125', '小米路由器3', '', '7');
INSERT INTO `xiaomi_product` VALUES ('126', '小米路由器3C', '', '7');
INSERT INTO `xiaomi_product` VALUES ('127', '小米路由器3G', '', '7');
INSERT INTO `xiaomi_product` VALUES ('128', '小米路由器3A', '', '7');
INSERT INTO `xiaomi_product` VALUES ('129', '小米路由器Pro', '', '7');
INSERT INTO `xiaomi_product` VALUES ('130', '小米路由器HD', '', '7');
INSERT INTO `xiaomi_product` VALUES ('131', 'WiFi放大器2', '', '7');
INSERT INTO `xiaomi_product` VALUES ('132', 'WiFi放大器Pro', '', '7');
INSERT INTO `xiaomi_product` VALUES ('133', 'WiFi电力猫', '', '7');
INSERT INTO `xiaomi_product` VALUES ('134', '小米VR眼镜', '', '7');
INSERT INTO `xiaomi_product` VALUES ('135', '随身WIFI', '', '7');
INSERT INTO `xiaomi_product` VALUES ('136', '千兆网线', '', '7');
INSERT INTO `xiaomi_product` VALUES ('137', '手机保护套', '', '7');
INSERT INTO `xiaomi_product` VALUES ('138', '手机贴膜', '', '7');
INSERT INTO `xiaomi_product` VALUES ('139', '自拍杆', '', '7');
INSERT INTO `xiaomi_product` VALUES ('140', '数据线', '', '7');
INSERT INTO `xiaomi_product` VALUES ('142', '黑鲨配件', '', '7');
INSERT INTO `xiaomi_product` VALUES ('143', '新小米移动电源2', '', '8');
INSERT INTO `xiaomi_product` VALUES ('144', '小米移动电源2C', '', '8');
INSERT INTO `xiaomi_product` VALUES ('145', '小米移动电源2', '', '8');
INSERT INTO `xiaomi_product` VALUES ('146', '小米随身手电筒', '', '8');
INSERT INTO `xiaomi_product` VALUES ('147', '移动电源保护套', '', '8');
INSERT INTO `xiaomi_product` VALUES ('148', '彩虹电池7号', '', '8');
INSERT INTO `xiaomi_product` VALUES ('149', '彩虹5号电池（10粒装）', '', '8');
INSERT INTO `xiaomi_product` VALUES ('15', '米粉卡 日租卡', '', '1');
INSERT INTO `xiaomi_product` VALUES ('150', '充电器', '', '8');
INSERT INTO `xiaomi_product` VALUES ('151', '小米车载充电器', '', '8');
INSERT INTO `xiaomi_product` VALUES ('152', '米家随身风扇', '', '8');
INSERT INTO `xiaomi_product` VALUES ('153', '小米插线板USB版', '', '8');
INSERT INTO `xiaomi_product` VALUES ('154', '米家插线板6位 基础版', '', '8');
INSERT INTO `xiaomi_product` VALUES ('155', '米家插线板3位长线版', '', '8');
INSERT INTO `xiaomi_product` VALUES ('156', '米家智能插线板', '', '8');
INSERT INTO `xiaomi_product` VALUES ('157', '小米头戴式蓝牙耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('158', '小米圈铁耳机2', '', '9');
INSERT INTO `xiaomi_product` VALUES ('159', '小米蓝牙项圈耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('16', '小米移动 电话卡', '', '1');
INSERT INTO `xiaomi_product` VALUES ('160', '小米游戏耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('161', '小米双单元半入耳式耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('162', '小米圈铁耳机 Pro', '', '9');
INSERT INTO `xiaomi_product` VALUES ('163', '小米圈铁耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('164', '小米活塞耳机 清新版', '', '9');
INSERT INTO `xiaomi_product` VALUES ('165', '小米降噪耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('166', '小米头戴式耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('167', '小米运动蓝牙耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('168', '小米运动蓝牙耳机mini', '', '9');
INSERT INTO `xiaomi_product` VALUES ('169', '小米蓝牙耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('170', '小米蓝牙音频接收器', '', '9');
INSERT INTO `xiaomi_product` VALUES ('171', '小米头戴式耳机 轻松版', '', '9');
INSERT INTO `xiaomi_product` VALUES ('172', '品牌耳机', '', '9');
INSERT INTO `xiaomi_product` VALUES ('173', '小米AI音箱', '', '9');
INSERT INTO `xiaomi_product` VALUES ('174', '小米小钢炮蓝牙音箱2', '', '9');
INSERT INTO `xiaomi_product` VALUES ('175', '小米方盒子蓝牙音箱2', '', '9');
INSERT INTO `xiaomi_product` VALUES ('176', '小米蓝牙音箱', '', '9');
INSERT INTO `xiaomi_product` VALUES ('177', '小米随身蓝牙音箱', '', '9');
INSERT INTO `xiaomi_product` VALUES ('178', '小米米兔音箱', '', '9');
INSERT INTO `xiaomi_product` VALUES ('179', '小爱音箱mini', '', '9');
INSERT INTO `xiaomi_product` VALUES ('18', '小米电视4 75英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('180', '旅行箱', '', '10');
INSERT INTO `xiaomi_product` VALUES ('181', '双肩包', '', '10');
INSERT INTO `xiaomi_product` VALUES ('182', '儿童书包', '', '10');
INSERT INTO `xiaomi_product` VALUES ('183', '胸包', '', '10');
INSERT INTO `xiaomi_product` VALUES ('184', '钱包', '', '10');
INSERT INTO `xiaomi_product` VALUES ('185', '收纳包', '', '10');
INSERT INTO `xiaomi_product` VALUES ('186', '服饰', '', '10');
INSERT INTO `xiaomi_product` VALUES ('187', '运动鞋', '', '10');
INSERT INTO `xiaomi_product` VALUES ('188', '围巾', '', '10');
INSERT INTO `xiaomi_product` VALUES ('189', '眼镜', '', '10');
INSERT INTO `xiaomi_product` VALUES ('19', '小米电视4A 32英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('190', '米家签字笔', '', '10');
INSERT INTO `xiaomi_product` VALUES ('191', '文具', '', '10');
INSERT INTO `xiaomi_product` VALUES ('192', '玻璃保鲜盒', '', '10');
INSERT INTO `xiaomi_product` VALUES ('193', '自动折叠伞', '', '10');
INSERT INTO `xiaomi_product` VALUES ('194', '螺丝刀', '', '10');
INSERT INTO `xiaomi_product` VALUES ('195', '米兔玩偶', '', '10');
INSERT INTO `xiaomi_product` VALUES ('196', '米兔磁力积木', '', '10');
INSERT INTO `xiaomi_product` VALUES ('197', '牙刷', '', '10');
INSERT INTO `xiaomi_product` VALUES ('198', '沙发', '', '10');
INSERT INTO `xiaomi_product` VALUES ('199', '枕头', '', '10');
INSERT INTO `xiaomi_product` VALUES ('2', '小米8 SE', '', '1');
INSERT INTO `xiaomi_product` VALUES ('20', '小米电视4A 40英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('200', '被子', '', '10');
INSERT INTO `xiaomi_product` VALUES ('201', '床垫', '', '10');
INSERT INTO `xiaomi_product` VALUES ('202', '针织件套', '', '10');
INSERT INTO `xiaomi_product` VALUES ('203', '饰品', '', '10');
INSERT INTO `xiaomi_product` VALUES ('21', '小米电视4A 43英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('22', '小米电视4A 43英寸青春版', '', '2');
INSERT INTO `xiaomi_product` VALUES ('23', '小米电视4A 49英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('24', '小米电视4A 50英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('25', '小米电视4A 55英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('26', '小米电视4A 65英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('27', '小米电视4X 55英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('28', '小米电视4C 32英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('29', '小米电视4C 43英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('3', '小米MIX 2S', '', '1');
INSERT INTO `xiaomi_product` VALUES ('30', '小米电视4C 50英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('31', '小米电视4C 55英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('32', '小米电视 体育版', '', '2');
INSERT INTO `xiaomi_product` VALUES ('33', '小米电视4 49英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('34', '小米电视4 55英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('35', '小米电视4 65英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('36', '小米电视4S 55英寸曲面', '', '2');
INSERT INTO `xiaomi_product` VALUES ('37', '小米电视4S 55英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('38', '小米电视4S 50英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('39', '小米电视4S 43英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('4', '小米6X', '', '1');
INSERT INTO `xiaomi_product` VALUES ('40', '小米电视4S 32英寸', '', '2');
INSERT INTO `xiaomi_product` VALUES ('41', '小米盒子', '', '2');
INSERT INTO `xiaomi_product` VALUES ('42', '小米游戏本 15.6\"', '', '3');
INSERT INTO `xiaomi_product` VALUES ('43', '笔记本Air 12.5\"', '', '3');
INSERT INTO `xiaomi_product` VALUES ('44', '笔记本Air 13.3\" 独显', '', '3');
INSERT INTO `xiaomi_product` VALUES ('45', '笔记本Air 13.3\" 集显', '', '3');
INSERT INTO `xiaomi_product` VALUES ('46', '笔记本Air 13.3\" 四核增强', '', '3');
INSERT INTO `xiaomi_product` VALUES ('47', '笔记本Pro 15.6\"', '', '3');
INSERT INTO `xiaomi_product` VALUES ('48', 'USB-C电源适配器', '', '3');
INSERT INTO `xiaomi_product` VALUES ('49', 'HDMI转接器', '', '3');
INSERT INTO `xiaomi_product` VALUES ('5', '黑鲨游戏手机', '', '1');
INSERT INTO `xiaomi_product` VALUES ('50', 'VGA 千兆网口转接器', '', '3');
INSERT INTO `xiaomi_product` VALUES ('51', '小米笔记本内胆包', '', '3');
INSERT INTO `xiaomi_product` VALUES ('52', '悦米机械键盘', '', '3');
INSERT INTO `xiaomi_product` VALUES ('53', '悦米机械键盘Pro静音版', '', '3');
INSERT INTO `xiaomi_product` VALUES ('54', '小米便携鼠标', '', '3');
INSERT INTO `xiaomi_product` VALUES ('55', '小米无线鼠标', '', '3');
INSERT INTO `xiaomi_product` VALUES ('56', '鼠标垫', '', '3');
INSERT INTO `xiaomi_product` VALUES ('57', 'DisplayPort转接器', '', '3');
INSERT INTO `xiaomi_product` VALUES ('58', 'USB至千兆网口转接器', '', '3');
INSERT INTO `xiaomi_product` VALUES ('59', '米家投影仪', '', '4');
INSERT INTO `xiaomi_product` VALUES ('6', '小米MIX 2', '', '1');
INSERT INTO `xiaomi_product` VALUES ('60', '空气净化器2', '', '4');
INSERT INTO `xiaomi_product` VALUES ('61', '空气净化器Pro', '', '4');
INSERT INTO `xiaomi_product` VALUES ('62', '净化器2S', '', '4');
INSERT INTO `xiaomi_product` VALUES ('63', '净化器MAX', '', '4');
INSERT INTO `xiaomi_product` VALUES ('64', '车载空气净化器', '', '4');
INSERT INTO `xiaomi_product` VALUES ('65', '小米净水器（厨下式）', '', '4');
INSERT INTO `xiaomi_product` VALUES ('66', '小米净水器（厨上式）', '', '4');
INSERT INTO `xiaomi_product` VALUES ('67', '小米净水器 1A （厨下式）', '', '4');
INSERT INTO `xiaomi_product` VALUES ('68', '空净滤芯', '', '4');
INSERT INTO `xiaomi_product` VALUES ('69', '小米净水器滤芯', '', '4');
INSERT INTO `xiaomi_product` VALUES ('7', '小米Max 2', '', '1');
INSERT INTO `xiaomi_product` VALUES ('70', '米家电水壶', '', '4');
INSERT INTO `xiaomi_product` VALUES ('71', '米家恒温电水壶', '', '4');
INSERT INTO `xiaomi_product` VALUES ('72', 'PM2.5检测仪', '', '4');
INSERT INTO `xiaomi_product` VALUES ('73', '水质TDS检测笔', '', '4');
INSERT INTO `xiaomi_product` VALUES ('74', '扫地机器人', '', '4');
INSERT INTO `xiaomi_product` VALUES ('75', '扫地机附件', '', '4');
INSERT INTO `xiaomi_product` VALUES ('76', '米家电饭煲', '', '4');
INSERT INTO `xiaomi_product` VALUES ('77', '米家电磁炉', '', '4');
INSERT INTO `xiaomi_product` VALUES ('78', '知吾煮厨具', '', '4');
INSERT INTO `xiaomi_product` VALUES ('79', '激光投影电视', '', '4');
INSERT INTO `xiaomi_product` VALUES ('8', '红米Note 5', '', '1');
INSERT INTO `xiaomi_product` VALUES ('80', '剃须刀', '', '4');
INSERT INTO `xiaomi_product` VALUES ('81', 'VR眼镜', '', '4');
INSERT INTO `xiaomi_product` VALUES ('82', '米家直流变频落地扇', '', '4');
INSERT INTO `xiaomi_product` VALUES ('83', '手环', '', '5');
INSERT INTO `xiaomi_product` VALUES ('84', '手表', '', '5');
INSERT INTO `xiaomi_product` VALUES ('85', '小米体脂秤', '', '5');
INSERT INTO `xiaomi_product` VALUES ('86', '小米体重秤', '', '5');
INSERT INTO `xiaomi_product` VALUES ('87', '米家电动牙刷', '', '5');
INSERT INTO `xiaomi_product` VALUES ('88', '智能家庭组合', '', '5');
INSERT INTO `xiaomi_product` VALUES ('89', '米家智能插座', '', '5');
INSERT INTO `xiaomi_product` VALUES ('9', '红米S2', '', '1');
INSERT INTO `xiaomi_product` VALUES ('90', '手电筒', '', '5');
INSERT INTO `xiaomi_product` VALUES ('91', '米家LED智能台灯', '', '5');
INSERT INTO `xiaomi_product` VALUES ('92', '米家飞利浦台灯', '', '5');
INSERT INTO `xiaomi_product` VALUES ('93', '米家感应夜灯', '', '5');
INSERT INTO `xiaomi_product` VALUES ('94', '床头灯', '', '5');
INSERT INTO `xiaomi_product` VALUES ('95', '吸顶灯', '', '5');
INSERT INTO `xiaomi_product` VALUES ('96', '智能灯泡', '', '5');
INSERT INTO `xiaomi_product` VALUES ('97', '米家小白智能摄像机', '', '5');
INSERT INTO `xiaomi_product` VALUES ('98', '小米米家智能摄像机云台版', '', '5');
INSERT INTO `xiaomi_product` VALUES ('99', '小方智能摄像机', '', '5');

-- ----------------------------
-- Table structure for xiaomi_product_version
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_product_version`;
CREATE TABLE `xiaomi_product_version` (
  `versionId` varchar(20) NOT NULL DEFAULT '',
  `detailVersion` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`versionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_product_version
-- ----------------------------
INSERT INTO `xiaomi_product_version` VALUES ('1', '全网通版 6GB+64GB');
INSERT INTO `xiaomi_product_version` VALUES ('2', '全网通版 6GB+128GB');
INSERT INTO `xiaomi_product_version` VALUES ('3', '全网通版 6GB+256GB');

-- ----------------------------
-- Table structure for xiaomi_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_shopping_cart`;
CREATE TABLE `xiaomi_shopping_cart` (
  `cartId` varchar(255) NOT NULL DEFAULT '',
  `userId` varchar(255) NOT NULL DEFAULT '',
  `number` int(11) NOT NULL DEFAULT '0',
  `specificationId` int(11) NOT NULL,
  PRIMARY KEY (`cartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for xiaomi_specification
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_specification`;
CREATE TABLE `xiaomi_specification` (
  `colorId` varchar(255) NOT NULL DEFAULT '' COMMENT '具体商品',
  `productId` varchar(255) NOT NULL,
  `versionId` varchar(255) NOT NULL,
  `stock` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `specificationId` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`specificationId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_specification
-- ----------------------------
INSERT INTO `xiaomi_specification` VALUES ('#000000', '1', '1', '100', '2699', '1');
INSERT INTO `xiaomi_specification` VALUES ('#000000', '1', '2', '100', '2999', '2');
INSERT INTO `xiaomi_specification` VALUES ('#000000', '1', '3', '100', '3299', '3');
INSERT INTO `xiaomi_specification` VALUES ('#0000FF', '1', '1', '100', '2699', '4');
INSERT INTO `xiaomi_specification` VALUES ('#0000FF', '1', '2', '100', '2999', '5');
INSERT INTO `xiaomi_specification` VALUES ('#0000FF', '1', '3', '100', '3299', '6');
INSERT INTO `xiaomi_specification` VALUES ('#ffffff', '1', '1', '100', '2699', '7');
INSERT INTO `xiaomi_specification` VALUES ('#ffffff', '1', '2', '100', '2999', '8');
INSERT INTO `xiaomi_specification` VALUES ('#ffffff', '1', '3', '100', '3299', '9');

-- ----------------------------
-- Table structure for xiaomi_type
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_type`;
CREATE TABLE `xiaomi_type` (
  `typeId` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `parentId` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_type
-- ----------------------------
INSERT INTO `xiaomi_type` VALUES ('0', '所有商品', '0');
INSERT INTO `xiaomi_type` VALUES ('1', '手机  电话卡', '0');
INSERT INTO `xiaomi_type` VALUES ('10', '生活  米兔', '0');
INSERT INTO `xiaomi_type` VALUES ('11', '小米手机', '1');
INSERT INTO `xiaomi_type` VALUES ('12', '红米手机', '1');
INSERT INTO `xiaomi_type` VALUES ('13', '电话卡', '1');
INSERT INTO `xiaomi_type` VALUES ('14', '小米盒子', '2');
INSERT INTO `xiaomi_type` VALUES ('15', '手环', '5');
INSERT INTO `xiaomi_type` VALUES ('16', '手表', '5');
INSERT INTO `xiaomi_type` VALUES ('17', '旅行箱', '10');
INSERT INTO `xiaomi_type` VALUES ('18', '双肩包', '10');
INSERT INTO `xiaomi_type` VALUES ('2', '电视  盒子', '0');
INSERT INTO `xiaomi_type` VALUES ('3', '笔记本', '0');
INSERT INTO `xiaomi_type` VALUES ('4', '智能  家电', '0');
INSERT INTO `xiaomi_type` VALUES ('5', '健康  家居', '0');
INSERT INTO `xiaomi_type` VALUES ('6', '出行  儿童', '0');
INSERT INTO `xiaomi_type` VALUES ('7', '路由器  手机配件', '0');
INSERT INTO `xiaomi_type` VALUES ('8', '移动电源  插线板', '0');
INSERT INTO `xiaomi_type` VALUES ('9', '耳机  音箱', '0');

-- ----------------------------
-- Table structure for xiaomi_user
-- ----------------------------
DROP TABLE IF EXISTS `xiaomi_user`;
CREATE TABLE `xiaomi_user` (
  `userId` varchar(255) NOT NULL DEFAULT '',
  `userName` varchar(20) NOT NULL DEFAULT '',
  `telephoneNumber` varchar(20) DEFAULT '',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `img` varchar(255) DEFAULT '',
  `hobby` varchar(255) DEFAULT '',
  `address` varchar(255) DEFAULT NULL,
  `sign` varchar(255) DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of xiaomi_user
-- ----------------------------
INSERT INTO `xiaomi_user` VALUES ('1', 'linhao1', '', '2018-06-08 11:33:56', '', '', null, '', '123456');
INSERT INTO `xiaomi_user` VALUES ('111', 'linhao', '3212132332321', '2018-06-08 11:33:56', '123', '123', 'sakhdjkas', '123', '123');
INSERT INTO `xiaomi_user` VALUES ('2', 'dailianghui', '', '2018-06-08 11:33:56', '', '', null, '', '123456');
INSERT INTO `xiaomi_user` VALUES ('626f33ca-1f22-4656-8e89-cdcd756b6269', 'lll', '13757107731', '2018-06-16 02:42:49', null, null, null, null, '1235');
INSERT INTO `xiaomi_user` VALUES ('87949b33-4fde-40b7-9886-b7a9f5aab328', 'lance', '13757107731', '2018-06-16 02:41:06', null, null, null, null, '1234');
INSERT INTO `xiaomi_user` VALUES ('9a9eb929-5c4c-4d61-913e-f003ebf2b3eb', 'dlh', '1234', '2018-06-09 13:23:20', null, null, null, null, '123');
INSERT INTO `xiaomi_user` VALUES ('bc30f342-2a84-4818-9ae4-c753b6be254f', '111', '13757107737', '2018-06-16 02:43:15', null, null, null, null, '1456');
