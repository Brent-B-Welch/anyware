# **Quick Start**



## Install Nacos

It's very simple, see here: https://nacos.io/en-us/docs/quick-start.html

Please run it in standalone mode for non-cluster setup.

Default username and password are "nacos".

Default port is 8848



## Install MySQL (version > 5.6)

run the sql script below:

```
cd ${anyware_home}/sql
mysql -uroot -p < anyware_product.sql
mysql -uroot -p < anyware_ware.sql
mysql -uroot -p < anyware_order.sql

```



## Install the warehouse application

### Clone the repo

```
git clone https://github.com/beiji-ma/anyware.git
```

Update the IP address in each application.yml/application-dev.yml if you deploy the Nacos and the app on the different host server.

![image-20211215002256711](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215002256711.png)



### Startup 2 modules below:

![image-20211215003614064](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215003614064.png)



***Congratulations*** if you could see the 2 service below from the console of Nacos:

![image-20211215003845653](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215003845653.png)



# Import the sample data:



## Inventory.json

![image-20211215004103907](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215004103907.png)



## Product.json

![image-20211215004201432](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215004201432.png)

