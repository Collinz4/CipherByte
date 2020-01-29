# CipherByte

I am currently working on a whitepaper for this cipher and will post it at some point.

Basically this cipher is similar to AES using counter mode. For every 512 bits of information. A sha512 hash is calculated using a session signature, user password, and the block's position (count). The hash is then XORed against the plaintext and the process is repeated until all the plaintext is encrypted. The session signature is added to the beginning of the ciphertext so decryption is possible.
