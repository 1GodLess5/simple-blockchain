public class Block {
    private String hash;
    private String previousHash;
    private String transaction;
    // nonce is number that blockchain miners are solving with
    private long nonce;

    public Block(String hash, String previousHash, String transaction, long nonce){
        this.hash = hash;
        this.previousHash = previousHash;
        this.transaction = transaction;
        this.nonce = nonce;
    }

    public String getHash(){
        return this.hash;
    }

    public String getPreviousHash(){
        return this.previousHash;
    }

    public String getTransaction(){
        return this.transaction;
    }

    public long getNonce(){
        return this.nonce;
    }
}
