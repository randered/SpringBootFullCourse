drop table if exists order_db cascade;

create table order_db
(
    id        bigint not null auto_increment primary key,
    customer      varchar(255)
) engine = InnoDB;