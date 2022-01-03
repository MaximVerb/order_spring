create table item
(
    item_id         int8           not null,
    description     varchar(255),
    name            varchar(255)   not null,
    price           numeric(19, 2) not null,
    stock_available int8           not null,
    warehouse_name  varchar(255)   not null,
    primary key (item_id)
);