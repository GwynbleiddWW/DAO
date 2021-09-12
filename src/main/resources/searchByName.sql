select product_name, netology.customers.name
from netology.customers
         join netology.orders on customers.id = customer_id
where (netology.customers.name) ilike (netology.customers.name);