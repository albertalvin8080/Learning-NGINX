; -> denotes a comment
; This file is a ZONE.

$TTL 86400

@       IN      SOA      ns.main.com.      hostmaster.main.com. (
        202     ; Serial
        600     ; Refresh
        3600    ; Retry
        1000000 ; Expire
        3600)   ; Negative Cache TTL

@       IN      NS       ns.main.com.

ns      IN      A        127.0.0.1


; EXPLANATION:

; @                   : This refers to the root domain ("main.com", the name of this file) itself.
; IN                  : This specifies the record type as "IN" (internet).
; SOA                 : This specifies the record type as "Start of Authority".
; ns.main.com.        : This is the primary name server for the zone.
; hostmaster.main.com.: This is the contact email for the zone administrator (often written as "hostmaster").
; ->>
;   - 202    : This is the serial number of the zone, used to track changes. It should be incremented whenever the zone data is updated.
;   - 600    : This is the refresh time in seconds (10 minutes) - how often secondary name servers should check with the primary for updates.
;   - 3600   : This is the retry time in seconds (1 hour) - how often a secondary should retry contacting the primary if it fails the first time.
;   - 1209600: This is the expire time in seconds (2 weeks) - how long a secondary should consider the zone data valid if it can't contact the primary.
;   - 3600   : This is the Negative Cache TTL in seconds (1 hour) - how long a negative response (record not found) should be cached.

; @ IN NS ns.main.com. - This line defines an NS record, specifying that "ns.main.com." is a name server for the "main.com" zone.

; ns IN A 127.0.0.1 - This line defines an `A` (ipv4) record for "ns.main.com." This is unusual because it points the name server to the loopback address (127.0.0.1), which refers back to the same machine.