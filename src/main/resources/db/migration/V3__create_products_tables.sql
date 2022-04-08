create table brands (id serial constraint brands_pk primary key,
                         brand varchar(50) not null, unique (brand)
                         );
create table categories (id serial constraint categories_pk primary key,
                         category varchar(50) not null, unique (category)
                         );

create table products (
	id serial constraint products_pk primary key,
	product_name varchar(100) not null,
	category_id bigint not null, unique(category_id),
	brand_id bigint not null,unique(brand_id),
	description varchar(100),
	price decimal(8,2),
    image varchar(100));
