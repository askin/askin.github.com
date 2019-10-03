---
Title: Slurm - Linux için bant genişliği takip aracı
Date: 2013-12-19T12:15:00+03:00
Author: askin
Category: ["Linux"]
Tags: ["ağ", "monitoring", "network"]
Slug: slurm-linux-icin-bant-genisligi-takip-araci
Status: published
---

Slurm temel olarak ağ trafiğini görüntülemek için kullanılan bir araçtır. Ağ kullanımını görselleştirerek kullanışlı bir çıktı üretir.

Debian tabanlı sistemlerde aşağıdaki gibi kurulum yapabihlirsiniz.

```bash
apt-get install slurm
```

Kurulumu tamamladıktan sonra komut satırından ağ trafiğinizi takip edebilirsiniz. En basit şekliyle aşağıdaki formatta komutu kullanabilirsiniz.

```bash
slurm -i [Ağ Arayüzü]
```

-i parametresi hangi ağ arayüzünün kullanılacanı belirtir.

```bash
slurm -i wlan0
```

```bash
slurm -i eth1
```

![Slurm](/uploads/2013/12/slurm.png)

Klavye kısa yolları:
Slurm etkileşim için birçok farklı tuşu destekler:

-   s split moduna geçiş yapar
-   c klasik moda geçiş yapar
-   l büyük grafik moduna geçer
-   L TX/RX ledini aktif eder
-   m kasik, büyük ve split modları arasında geçiş yapar
-   z sayaçları 0'lar
-   r ekranı yeniden çizer
-   q çıkış yapar

Aynı zamanda bu kısayol tuşlarını parametre olarak da verebilirsiniz.

```bash
slurm -i eth1 -L
```

Kaynak: <http://lintut.com/slurm-command-line-bandwidth-monitoring-tool-for-linux/>
