import base64
import hashlib
import datetime
import time

def generateSecureLink(secret, uri, expires):
    # The usage of `:` avoids colisions.
    formatted_str = f"{secret}:{uri}:{expires}"

    # The hexdigest() method is not used because it returns a string that contains hexadecimal digits. These digits include characters from 'a' to 'f' and '0' to '9'. The resulting string may not be safe for use in URLs without further processing. Also, Base64 encoding is more compact than hexadecimal. 
    md5_bytes = hashlib.md5(formatted_str.encode("utf-8")).digest() # Returns the binary equivalent of the hash value.
    print(md5_bytes)
    md5_base64_bytes = base64.urlsafe_b64encode(md5_bytes)
    print(md5_base64_bytes)
    md5_string = md5_base64_bytes.decode("utf-8").rstrip("=")

    return f"{uri}?md5={md5_string}&expires={expires}";

if __name__ == "__main__":
    # secret = 1234567 # Must be the same secret used inside `$secure_link_md5`
    secret = 7654321

    # uri = "/files/image.png"
    # uri = "files/dino.png" # Removed the trailing slash. Check the location block inside nginx.
    uri = "static/mysecret.html"

    date_time = datetime.datetime(2024, 10, 10, 0, 0)
    expires = int(time.mktime(date_time.timetuple())) # Basically parses the datetime to seconds

    secure_link = generateSecureLink(secret, uri, expires)
    print(secure_link)