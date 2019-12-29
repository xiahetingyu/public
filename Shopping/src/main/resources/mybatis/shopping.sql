/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019.05.21 15:57:53                          */
/*==============================================================*/


drop table if exists address;

drop table if exists clazz;

drop table if exists detail;

drop table if exists orderr;

drop table if exists product;

drop table if exists user;

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
create table address
(
   id                   int not null auto_increment,
   email                varchar(255),
   nickname             varchar(256),
   name                 varchar(256),
   local                varchar(1024),
   zip                  varchar(256),
   phone                varchar(256),
   other                varchar(256),
   time                 timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: clazz                                                 */
/*==============================================================*/
create table clazz
(
   id                   int not null auto_increment,
   p                    int,
   s                    int,
   level                int,
   name                 varchar(256),
   time                 timestamp,
   primary key (id),
   unique key AK_p (p),
   key AK_s (s)
);

/*==============================================================*/
/* Table: detail                                                */
/*==============================================================*/
create table detail
(
   id                   int not null auto_increment,
   orderr               varchar(255),
   p_id                 int,
   name                 varchar(512),
   count                int,
   subtotal             double,
   time                 timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: orderr                                                */
/*==============================================================*/
create table orderr
(
   id                   int not null auto_increment,
   email                varchar(255),
   a_id                 int,
   orderr               varchar(255),
   total                double,
   status               int,
   time                 timestamp,
   primary key (id),
   unique key AK_orderr (orderr)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   id                   int not null auto_increment,
   s                    int,
   name                 varchar(512),
   author               varchar(512),
   cover                varchar(512),
   press                varchar(512),
   press_date           timestamp,
   edition              varchar(512),
   print_date           timestamp,
   impression           varchar(512),
   isbn                 varchar(512),
   word_num             varchar(512),
   page_num             int,
   size                 varchar(512),
   paper                varchar(512),
   pack                 varchar(512),
   price                double,
   dprice               double,
   create_date          timestamp,
   editor_recommend     varchar(512),
   content_abstract     varchar(512),
   author_abstract      varchar(512),
   director             varchar(512),
   media_commentary     varchar(512),
   sale                 int,
   stock                int,
   time                 timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   email                varchar(255),
   nickname             varchar(256),
   password             varchar(256),
   permission           int,
   code                 varchar(256),
   time                 timestamp,
   primary key (id),
   unique key AK_email (email)
);

alter table address add constraint FK_address_user foreign key (email)
      references user (email) on delete restrict on update restrict;

alter table detail add constraint FK_detail_orderr foreign key (orderr)
      references orderr (orderr) on delete restrict on update restrict;

alter table detail add constraint FK_detail_product foreign key (p_id)
      references product (id) on delete restrict on update restrict;

alter table orderr add constraint FK_orderr_address foreign key (a_id)
      references address (id) on delete restrict on update restrict;

alter table orderr add constraint FK_orderr_user foreign key (email)
      references user (email) on delete restrict on update restrict;

alter table product add constraint FK_product_clazz foreign key (s)
      references clazz (s) on delete restrict on update restrict;

