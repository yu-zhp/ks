# ks企业级框架
`基于springcloud的框架`  
使用nacos作为注册中心和配置中心  
使用zk+kafka作为消息中间件为日志系统提供高并发，高吞吐的日志系统  
使用mongoDB替代关系型数据库存储（也可以替换为mysql）  


**Nacos配置**  
配置存储在mysql，也可与作者共用配置（联系加权限）  
阿里云mysql地址配置:  
spring.datasource.platform=mysql  
db.num=1  
db.url.0=jdbc:mysql://rm-uf66886jw0034swn3mo.mysql.rds.aliyuncs.com:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.user=nacos  
db.password=nacos@123  

**自定义mysql配置：**  
1.mysql创建数据库nacos_config  
2.导入sql文件nacos_config.sql  
3.配置nacos的application.properties文件，修改mysql地址为自己的  

提供阿里云nacos服务注册集群（仅注册，配置不可用）  
公测版URL:mse-deae08a3-p.nacos-ans.mse.aliyuncs.com:8848  

启动环境：kafka,mongoDB,nacos,mysql  
