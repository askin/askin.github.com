---
Title: Rhythmbox m4a - mp4 faad
Date: 2008-05-13T14:07:00+03:00
Author: Aşkın Özgür
Category: Linux
Tags: ["Codec", "faad", "Linux", "m4a", "mp4"]
Slug: rhythmbox-m4a-mp4-faad
Status: published
---

Bügün m4a uzantılı mp4 dosyalarını rhythmboxda çalma listesine eklemeye çalışırken, rhythmbox bana hiç bir tepki vermiyordu. Aynı dosyayı totem ile sorunsuz açabiliyordum. Biraz araştırınca rhythmboxın [faad](http://sourceforge.net/projects/faac/) adlı eklentiye(aslında konsoldan çalışan bir nevi medya oynatıcı) ihtiyaç duyduğunu öğrendim.  
Eğer debian temelli bir dağıtım kullanıyorsanız aşağıdaki komut işinizi görecektir.  
`aptitude install faad`
