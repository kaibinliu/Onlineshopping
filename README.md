# onlineshopping
<p>项目配置时要把src/com/servlet目录下UploadServlet中的multiplepart注解以及basepath中的路径信息改成当前WebContent目录下的img目录地址的路径</p>
  <p>解决卖家发布商品后后，卖家后台需刷新几次界面才能显示图片问题：在eclipse中需要双击Tomcat服务器更改其Web Modules，点击Add External Web Modules按键添加img目录路径，Path填“/img”。</p>
