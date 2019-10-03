---
Title: Solariste Özyinelemeli grep
Date: 2012-06-06T16:43:00+03:00
Author: askin
Category: Linux
Tags: ["bash", "find", "grep", "solaris"]
Slug: solariste-ozyinelemeli-grep
Status: published
---

Özyinelemeli grep çok kullanışlı bir araç. Malesef solariste bulunan grep öz yinelemeli çalışmıyor. Ama bunu aşmak çok zor değil.

```bash
$ grep 'ara' `find . -name '*'`
```
