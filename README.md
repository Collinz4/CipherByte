# CipherByte

I am currently working on a whitepaper for this cipher and will post it soon.

In a nutshell the cipher is similar to AES using counter mode. For every 512 bits of information. A sha512 hash is calculated using a session signature, user password, and the round's count. The hash is then XORed against the information and then works on the next 512 bits. The session signature is added to the beginning of the encrypted data so decryption is possible.
