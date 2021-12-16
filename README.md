

# Introduction 

*NOTE: You can refer to the pdf version for the attached photos.*

## Data Model Explained

![image-20211216104713866](docs/assets/image-20211216104713866.png)



## Naming Convention - API



### */<module_name>/<model-name>/*

- E.g., /product/product/: 
- 1st product is the module’s name, 
- 2nd is the model’s name. a module could have many model.
- The operation could be on the set of Products, including create or list.



### */<module_name>/<model_name>/{id}*

- E.g., /product/product/1: 
- The product id is 1
- The operation could be GET, DELETE, PUT on the product by given id



### */<module_name>/<model_name>/{id}/<options>*

- E.g., /product/product/1/withart: 
- Inspect the information for Product which product_id is 1, including the composed of Articles.



## Project Structure Explained

Coming soon (Not Started)

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

![image-20211215002256711](docs/assets/image-20211215002256711.png)

You need update the pom.xml to remove the setup related with nexus:



![image-20211215005903693](docs/assets/image-20211215005903693.png)



### Startup 2 modules below:

![image-20211215003614064](docs/assets/image-20211215003614064.png)



***Congratulations*** if you could see the 2 service below from the console of Nacos:

![image-20211215003845653](docs/assets/image-20211215003845653.png)



# Import the sample data:



## Inventory.json

![image-20211215004103907](docs/assets/image-20211215004103907.png)



## Product.json

![image-20211215004201432](docs/assets/image-20211215004201432.png)



Test:



Case 1.1: list all Inventory information



![image-20211215004540296](docs/assets/image-20211215004540296.png)



Case 1.2: Update stock



![image-20211215004948779](docs/assets/image-20211215004948779.png)



Case 1.3: Add Article(Inventory Item)



![image-20211215005055179](docs/assets/image-20211215005055179.png)



Case 1.4: Delete Article (Inventory Item)

![image-20211215010759131](docs/assets/image-20211215010759131.png)





Case 2.1: Query Order

![image-20211215005245196](docs/assets/image-20211215005245196.png)



Case 2.2: Create Order



![image-20211215005353696](docs/assets/image-20211215005353696.png)



Case 2.3: Ware Order Task



![image-20211215012510088](docs/assets/image-20211215012510088.png)



Case 3.1: Available stock for each product



![image-20211215010520774](docs/assets/image-20211215010520774.png)



Case 4.1: Lock Stock for Order (Incompleted)

![image-20211215012824020](docs/assets/image-20211215012824020.png)



Case 5.1: Query Product Article Relation

![image-20211215012958919](docs/assets/image-20211215012958919.png)



5.2: Create Product Article Relation



![image-20211215013118728](docs/assets/image-20211215013118728.png)



5.3: Update Product Article Relation

![image-20211215013220321](docs/assets/image-20211215013220321.png)



5.4: Delete Product Article



![image-20211215013318731](docs/assets/image-20211215013318731.png)