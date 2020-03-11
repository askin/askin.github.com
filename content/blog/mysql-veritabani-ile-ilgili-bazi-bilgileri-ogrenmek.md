---
Title: MySQL veritabanı ile ilgili bazı bilgileri öğrenmek
Date: 2013-09-06T12:59:00+03:00
Author: Aşkın Özgür
Category: Programlama
Tags: ["database", "mysql", "query", "sorgu"]
Slug: mysql-veritabani-ile-ilgili-bazi-bilgileri-ogrenmek
Status: published
---

MySQL kullanıyorsanız, phpMyAdmin gibi bir arayüzünüz olmadığı zaman veritabanı ile ilgili bilgi almak için aşağıdaki sorguları kullanabilirsiniz.

Var olan veritabanlarını görmek:

```sql
show databases;
```

Bir veritabanını kullanmak için seçmek:

```sql
use veritabani_ismi;
```

Bir veritabanındaki tabloları listelemek:

```sql
show tables;
```

```sql
show tables from veritabani_ismi;
```

Bir tablonun oluşturulma scriptini görme:

```sql
show create table tablo_ismi
```

Bir tablonun kolonlarını görme:

```sql
describe tablo_adi
```
