---
title: Linuxda du kullanırken gizli dosyaları dahil etmek
date: 2019-10-04T12:04:25+03:00
Author: askin
Category: ["Linux"]
Tags: ["linux"]
Slug: du-wildcard-ile-gizli-dosyalar
draft: false
---

`du` komutunu çok sık kullanıyorum. Makinede yer sıkıntısı yaşadığım zaman kesinlikle hayat kurtarıyor. Genellikle
aşağıdaki şekilde kullanıyorum.

```bash
du -sh * | sort -h
```

Bu komut anlaşılır bir birimle tüm alt dizinlerin boyutlarını hesaplayıp küçükten büyüğe doğru sıralıyor. Bu komutun ve
**birçok linux komutunun** sıkıntısı, wildcard kullanıldığında gizli dosyaları/dizinleri göstermiyor. Tabi bu
kullandığınız kabukla ilgili. Ben bash kullanıyorum. Bunu aşmak için komutu aşağıdaki şekilde kullanabilirsiniz.

```bash
du -sh .[!.]* * | sort -h
```

Bu komutun da biraz sıkıntılar var. Mesela dosya ismi iki nokta ile başlıyorsa listelemeyecek malesef. Fakat bu şekilde
işimi görüyor.
