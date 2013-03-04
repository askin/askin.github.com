---
layout: page
title: Aşkın Yollu's Weblog
tagline:
---
{% include JB/setup %}

{% for post in site.posts %}
<div>
    <a href="{{ BASE_PATH }}{{ post.url }}"><h3>{{ post.title }}</h3></a>
    <h6>
        {{ post.date | date_to_string }} &bull; <a href="{{ site.url }}/{{ post.url }}#disqus_thread">Yorumlar</a>
    </h6>
</div>
{% endfor %}
   <script type="text/javascript">
    /* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
    var disqus_shortname = 'askinblog'; // required: replace example with your forum shortname

    /* * * DON'T EDIT BELOW THIS LINE * * */
    (function () {
        var s = document.createElement('script'); s.async = true;
        s.type = 'text/javascript';
        s.src = 'http://' + disqus_shortname + '.disqus.com/count.js';
        (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(s);
    }());
</script>
