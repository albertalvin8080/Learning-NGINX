; -> denotes a comment

$ttl 86400

@     IN     SOA    ns.main.com.    hostmaster.com. (
    202     ; Serial
    600     ; Refresh
    3600    ; Retry
    1000000 ; Expire
)

@     IN     NS     ns.main.com.
ns    IN     A      127.0.0.1