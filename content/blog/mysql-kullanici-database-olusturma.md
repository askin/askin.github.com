---
Title: Mysql Kullanıcı - Database Oluşturma
Date: 2012-07-11T13:54:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["create", "database", "grant", "Linux", "mysql", "sql"]
Slug: mysql-kullanici-database-olusturma
Status: published
---

Herzaman unutup google'a bakacağıma buraya bakayım daha kolay :)

Önce mysql sunucusuna bağlanalım:
```bash
mysql -u root -p
```

Kullanıcı oluşturma:
```sql
create user kullaniciadi;
```

Veritabanı oluşturma:

```sql
create database veritabaniadi;
```

Kullanıcı yetkilerini verme:
Tüm yetkiler:

```sql
grant all on veritabaniadi.* to kullaniciadi@localhost identified by 'parola';
```

Sadece okuma (select):

```sql
grant select on veritabaniadi.* to kullaniciadi@localhost;
```

Yetkiler hemen devreye girsin:
```sql
flush privileges;
```
