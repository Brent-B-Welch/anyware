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

You need update the pom.xml to remove the setup related with nexus:



![image-20211215005903693](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215005903693.png)



### Startup 2 modules below:

![image-20211215003614064](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215003614064.png)



***Congratulations*** if you could see the 2 service below from the console of Nacos:

![image-20211215003845653](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215003845653.png)



# Import the sample data:



## Inventory.json

![image-20211215004103907](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215004103907.png)



## Product.json

![image-20211215004201432](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215004201432.png)



Test:



Case 1: list all Inventory information



![image-20211215004540296](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215004540296.png)



Case 2: Update stock



![image-20211215004948779](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215004948779.png)



Case 3: Add Article



![image-20211215005055179](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215005055179.png)



Case 4: Query Order

![image-20211215005245196](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215005245196.png)



Case 5: Create Order



![image-20211215005353696](C:\Users\creator\AppData\Roaming\Typora\typora-user-images\image-20211215005353696.png)



