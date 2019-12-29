/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019.05.28 19:50:42                          */
/*==============================================================*/
use proxy;

drop table if exists history;

drop table if exists orderr;

drop table if exists other;

drop table if exists proxye;

drop table if exists recharge;

drop table if exists user;

/*==============================================================*/
/* Table: history                                               */
/*==============================================================*/
create table history
(
    id       int not null auto_increment,
    username varchar(255),
    proxye   varchar(255),
    other    varchar(1024),
    time     timestamp,
    primary key (id)
);

/*==============================================================*/
/* Table: orderr                                                */
/*==============================================================*/
create table orderr
(
    id       int not null auto_increment,
    username varchar(255),
    count    int,
    amount   double,
    status   int,
    other    varchar(1024),
    time     timestamp,
    primary key (id)
);

/*==============================================================*/
/* Table: other                                                 */
/*==============================================================*/
create table other
(
    id       int not null auto_increment,
    username varchar(255),
    balance  double,
    count    int,
    other    varchar(1024),
    time     timestamp,
    primary key (id),
    unique key AK_username (username)
);

/*==============================================================*/
/* Table: proxye                                                */
/*==============================================================*/
create table proxye
(
    id     int not null auto_increment,
    proxye varchar(255),
    ip     varchar(512),
    port   varchar(512),
    ver    int,
    other  varchar(1024),
    time   timestamp,
    primary key (id),
    unique key AK_proxye (proxye)
);

/*==============================================================*/
/* Table: recharge                                              */
/*==============================================================*/
create table recharge
(
    id       int not null auto_increment,
    username varchar(255),
    amount   double,
    status   int,
    other    varchar(1024),
    time     timestamp,
    primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
    id         int not null auto_increment,
    nickname   varchar(512),
    username   varchar(255),
    password   varchar(512),
    path       varchar(512),
    phoneCode  varchar(512),
    permission int,
    other      varchar(1024),
    time       timestamp,
    primary key (id),
    unique key AK_username (username)
);

alter table history
    add constraint FK_History2Proxye foreign key (proxye)
        references proxye (proxye) on delete cascade on update cascade;

alter table history
    add constraint FK_History2User foreign key (username)
        references user (username) on delete cascade on update cascade;

alter table orderr
    add constraint FK_Orderr2User foreign key (username)
        references user (username) on delete cascade on update cascade;

alter table other
    add constraint FK_Other2User foreign key (username)
        references user (username) on delete cascade on update cascade;

alter table recharge
    add constraint FK_Recharge2User foreign key (username)
        references user (username) on delete cascade on update cascade;

