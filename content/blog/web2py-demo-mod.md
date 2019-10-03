---
Title: web2py demo mode
Date: 2013-02-26T15:28:00+03:00
Author: askin
Category: Programlama
Tags: ["python", "web"]
Slug: web2py-demo-mod
Status: published
---

Bugün web2py ile uğraşırken, localhost üzerinde çalıştırmadığım için oluşan ticketları göremedim, o an için localhost'ta çalıştıramadığımdan dolayı web2py'yi demo modundan çalıştırmak zorunda kaldım. Bunu yapmak için *applications/admin/models/0.py* dosyasında *7*. satırdaki

```bash
DEMO_MODE = False
```

satırını

```bash
DEMO_MODE = True
```

olarak değiştirmem yetti.
