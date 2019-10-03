---
Title: Bir dosyanın boş olup olmadığını kontrol etme
Date: 2012-11-07T13:44:00+03:00
Author: askin
Category: Linux
Tags: ["bash", "bos dosya", "empty", "Linux", "script"]
Slug: bir-dosyanin-bos-olup-olmadigini-kontrol-etme
Status: published
---

Shell script yazarken bir dosyanın boş olup olmadığını kontrol etmemiz gerekebilir. Bunu yapmak için birkaç yöntem yazacağım.

```bash
satirsayisi=`wc  -l 194.27.108.90  | awk '{split($0,a," "); print a[1]}'`
if [ $satirsayisi == 0 ]; then echo "dosya bos"; fi
```

```bash
if [ -z $(cat dosyaadi) ]; then echo "dosya bos"; fi
```

```bash
if [ -z `cat dosyaadi` ]; then echo "dosya bos"; fi
```

Ve en güzeli

```bash
if [ -s dosyaadi ]; then echo "Dosya dolu"; else echo "Dosya bos"; fi
```
