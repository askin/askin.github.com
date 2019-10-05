---
Title: Gtk <= 2.18.9 Pencere Gizleme Sorunu
Date: 2010-04-08T06:19:00+03:00
Author: askin
Category: Programlama
Tags: ["c/c++", "grep", "gtk"]
Slug: gtk-2-18-9-pencere-gizleme-sorunu
Status: published
---

![Gtk](/uploads/2010/04/gtk.png "Gtk")Gece gece uyku tutmadı var olan bir programı kurcalamaya başladım. Amacım programın sitem çekmecesinden çalışabilir hale getirmekti.

Her şeyi yaptım fakat bir türlü pencereyi gizleyemiyordum :) Doküman *gtk\_window\_get\_mnemonics\_visible ()* fonksiyonunu kullanmamı söylüyordu, fakat kullandığım gtk sürümünde bu fonksiyon tanımlı değildi(2.18.7). Eski sürüm için olan dokümanı incelediğimde bu işi yapan bir fonksiyon yoktu.
Sistemde kurulu gtk ve python ile bu işi yapabiliyordum. Normal olarak c ile de yapabilmem lazımdı:)
Biraz inceledikten sonra, önce pencereyi gizleyen, ardından boyutunu eski haline getirip sonra tekrar gösteren bir fonksiyon olduğunu fark ettim. Benim istediğim işi yapıyor fakat yanında birde fazlalığı vardı.(gtk\_window\_reshow\_with\_initial\_size)
İnternette biraz daha araştırıp umudumu kaybedince mecburen kaynak koda baktım.

    grep -rHn gtk_window_reshow_with_initial_size *

bu komut bana gtk\_window\_reshow\_with\_initial\_size fonksiyonun nerelerde olduğunu gösterdi.
Bu fonksiyonunun içine bakınca istediğim kodu hemen buldum :)

```C
gtk_window_reshow_with_initial_size (GtkWindow *window)
{
  GtkWidget *widget;

  g_return_if_fail (GTK_IS_WINDOW (window));

  widget = GTK_WIDGET (window);

  gtk_widget_hide (widget);
  gtk_widget_unrealize (widget);
  gtk_widget_show (widget);
}
```

Önce pencereyi widgeta çevirebilme imkanım varmış, böyle basit bir şeyi nasıl bulamadım bilemiyorum.
