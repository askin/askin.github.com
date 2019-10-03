---
Title: PyGtk ile Sistem Çekmecesi
Date: 2010-04-07T21:53:00+03:00
Author: askin
Category: Programlama
Tags: ["gtk", "icon", "pygtk", "python", "status"]
Slug: pygtk-ile-sistem-cekmecesi
Status: published
---

![Gtk](/uploads/2010/04/gtk.png "Gtk")Gtk ile çok kolay bir şekilde geliştirdiğiniz uygulamayı sistem çekmecesinde gösterebilirsiniz.

Ufak bir örnek kod veriyorum. Onun üzerinden anlatacağım.

```python
import pygtk
import gtk

class ShowIcon:
    def __init__(self):
    self.icon = gtk.StatusIcon()
        self.icon.set_from_file('gtk.png')
        self.icon.set_tooltip_text('Hello Python!!!')
        self.icon.set_visible(True)
        self.icon.connect("activate", self.hello)
        gtk.main()

    def hello(self, widget):
        print 'Hello Python !!!'

if __name__ == '__main__':
    icon = ShowIcon()
```

6\. satırda asıl işimizi yapacak olan *StatusIcon* nesnesini yaratıyoruz.  
7. satırda sistem çekmecesinde hangi ikonun görüntüleneceğini belirtiyoruz. *set\_from\_file* ikonu dosyadan alacağımız anlamına geliyor. Eğer gtk'nın sunduğu standart ikonları kullanmak istiyorsanız set\_from\_stock kullanmalısınız.

```python
icon.set_from_stock(gtk.STOCK_ABOUT)
```

8\. satırda ikonun üzerine geldiğimizde görünmesini istediğimiz yazıyı belirliyoruz.  
9. satırda ikonun başlangıçtaki görünürlüğünü belirliyoruz. Bu satırı yazmasak da görünür başlıyor.  
10. satırda ikonun *"activate"* sinyali aldığında çağırmasını istediğimiz metodu belirliyoruz. Kısacası üzerine tıklandığında ne iş yapacağını belirtiyoruz. *"activate"* yerine *"popup\_menu"* yazarsak ikona sağ tıkladığımızda çağrılacak metodu belirliyoruz.  
11. gkt.main() haydi yapalım şu işi manasında :)

Ayrıntılı dökümanı [PyGtk Belgelerinde](http://www.pygtk.org/docs/pygtk/class-gtkstatusicon.html) bulabilirisiniz. Yukarıda verdiğim kodu ve benim kullandığım ikonu [buradan](/uploads/2010/04/python-system-tray.zip) indirebilirsiniz.
