alter table if exists orders
    add constraint FKqfvu6jkb2v6d9l08ngtlma7rb foreign key (user_fk) references users;
alter table if exists ordered_item
    add constraint FKli6euuqgc9rcmr9aqh38hsyds foreign key (item_fk) references item;
alter table if exists ordered_item
    add constraint FKs8fb8g8ebgq4fe4sg5by9lmne foreign key (ordered_items_fk) references orders;