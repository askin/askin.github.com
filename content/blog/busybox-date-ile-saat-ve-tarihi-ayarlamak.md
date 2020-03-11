---
Title: BusyBox - date ile saat ve tarihi ayarlamak
Date: 2010-12-01T13:42:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["bash", "busybox", "date", "Linux", "saat"]
Slug: busybox-date-ile-saat-ve-tarihi-ayarlamak
Status: published
---

BusyBox içinde gelen date komutunun kullanımı biraz daha farklı. Saat ayarlamada bir değişiklik yok fakat tarihi ayarlamak biraz daha farklı. Saat ayarlama:

```bash
date -s "23:59:59"
```

Tarih ve saati ayarlama

```bash
date -s AAGGSSDDYYYY
date -s 123123592010
```

12-31-2010 23:59'a karşılık geliyor.
