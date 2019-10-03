---
Title: PyGtk ve Thread Sorunu
Date: 2010-04-06T23:03:00+03:00
Author: askin
Category: Programlama
Tags: ["gdk", "gtk", "Programlama", "pygtk", "python"]
Slug: pygtk-ve-thread-sorunu
Status: published
---

![Gtk](/uploads/2010/04/gtk.png "Gtk")PyGtk ile ara yüzüzünü hazırladığım bir program içinde thread kullanmam gerekiyordu. Kod çalışıyordu fakat thread işlemi istediğim gibi çalışmıyordu. Arayüzde bir değişiklik olduğu zaman thread çalışıyor, onun dışında hiç bir şekilde tepki vermiyordu.

Uzun süre hatanın kodda olabileceğini düşündüm. Ama sonunda python gtk.main() ve thread 3'lüsünü aynı sorgu içinde googleda aratınca cevabı buldum. Gtk'ya thread kullandığımı anlatmam gerekiyordu :)

```python
gtk.gdk.threads_init()
```

Bu satırı kodumun başına eklediğimde herşey istediğim gibi çalışmaya başladı :)

Sizde böyle bir sorunla karşılaşırsanız aklınızda bulunsun :)
