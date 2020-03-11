---
Title: Genius! 
Date: 2010-11-24T14:11:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["bash", "Linux", "ssh", "symlink"]
Slug: genius
Status: published
---

Scp ile sembolik linkleri takip etmeden indirme işlemi yapmak için araştırma yaptığımda, aşağıdaki kodu buldum. Böyle bir kullanım 40 yıl düşünsem aklıma gelmezdi.

```bash
cd /destination/directory
ssh user@remote.host "cd /original/directory; tar cf - ./" | tar xvf -
```

[Kaynak](http://www.linuxquestions.org/questions/linux-general-1/recursive-scp-w-o-following-links-658857/)
