---
Title: Cron Timezone Problemi
Date: 2020-09-04
Author: Aşkın Özgür
Category: Linux
Tags: ["crontab", "timezone"]
Status: published
---

Zamanlanmış görevler için cron'u sık sık kullanıyorum. Bugüne kadar
beni yarı yolda bıraktığı hiç olmadı. Birkaç gün önce iş arkadaşım
gece 12de çalışması gereken bir işin, gece 3te çalıştığını
bildirdi. Önce böyle birşey olmaz dedim ama loglara bakınca doğru
olduğunu anladım.

Biraz araştırınca şunu öğrendim, timezona değiştiğinde eğer cron
servisi yeniden başlatılmazsa eski timezone'u kullanmaya devam
ediyor. 

Kullandığız sistem göre aşağıdaki gibi bir komutla cron servisini
yeniden başlatabilirsiniz.

    service cron restart
