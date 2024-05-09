$TTL 86400

@       IN      SOA      ns.secondary.com.      hostmaster.main.com. (
        202     ; Serial
        600     ; Refresh
        3600    ; Retry
        1000000 ; Expire
        3600)   ; Negative Cache TTL

@       IN      NS       ns.secondary.com.

ns      IN      A        127.0.0.1
