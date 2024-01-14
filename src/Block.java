class Block {
    private String hash;
    private String previousHash;
    private String transaction;
    // nonce is number that blockchain miners are solving with
    private long nonce;

    Block(String hash, String previousHash, String transaction, long nonce){
        this.hash = hash;
        this.previousHash = previousHash;
        this.transaction = transaction;
        this.nonce = nonce;
    }

    String getHash(){
        return this.hash;
    }

    String getPreviousHash(){
        return this.previousHash;
    }

    String getTransaction(){
        return this.transaction;
    }

    long getNonce(){
        return this.nonce;
    }
}
