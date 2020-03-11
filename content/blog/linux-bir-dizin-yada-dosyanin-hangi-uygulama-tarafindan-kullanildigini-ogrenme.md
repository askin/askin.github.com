---
Title: Linux - Bir dizin yada dosyanın hangi uygulama tarafından kullanıldığını öğrenme
Date: 2008-05-24T13:30:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["Kabuk", "Linux"]
Slug: linux-bir-dizin-yada-dosyanin-hangi-uygulama-tarafindan-kullanildigini-ogrenme
Status: published
---

Bazen bir dosyayı silmeye çalıştığımızda yada bir diski ayırmaya çalıştığımızda, dosyanın meşgul olduğunu belirten bir uyarı çıkar ve işimizi yapmamızı engeller. Bu gibi durumlarda  
`fuser -m -u /dosya-dizin`  
komutunu kullanarak hangi sürecin (process) bize engel olduğunu öğreniriz.  
*-u* paramatresi sürecin sahibini gösterir.  
`kill`  
komutunu kullanarak süreci sonlandırıp işimizi tamamlayabiliriz, yada  
`ps auxw`  
komutunu kullanarak sürecin hangi uygulamaya ait olduğunuz öğrenebiliriz.

kaynak: [linux focus](http://www.linuxfocus.org/Turkce/September2004/article349.shtml)
