---
Title: Komut satırından resimleri pdf slaytına dönüştürme
Date: 2009-02-27T20:29:00+03:00
Author: askin
Category: Linux
Tags: ["convert", "image", "imagemagick", "jpg", "Linux", "pdf", "pptx"]
Slug: komut-satirindan-resimleri-pdf-slaytina-donusturme
Status: published
---

![ImageMagick](/uploads/2009/02/imagemagick.png "ImageMagick")Lanet dersimiz File System için hocamız pptx uzantılı bir dosya verince banada bunu bir şekilde pdf'e çevirmek düştü.  
Önce openoffice ile açmayı denedim, açıyordu fakat anlaşılır bir halde değildi. Bende alıp arkadaşımın bilgisayarına gittim, fakat onda da pdf'e dönüştüremiyordum. Dönüştürebildiğim formatlara bakarken .jpg'i gördüm. Nasılsa linuxta bu bi şekilde pdf'e dönüştürüm diyerek kendimden emin bi şekilde dönüşümü yapıp odama geçtim.  
2 buçuk dakikalık bir arama ile aradığımı buldum, [ImageMagick](http://www.imagemagick.org/) bu işi yapabiliyormuş.  
`convert *.jpg slayt.pdf` komutu iş görüyor.  
Tam tersini yapmak isterseniz  
`convert slayt.pdf resim.jpg`  
Artıntılı bilgi için:  
`man convert` :)

Bu sıralar inek moduna geçtiğim için ders maceralarım hakkında bol bol girdi yazacağım gibi:)
