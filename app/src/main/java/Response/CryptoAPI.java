package Response;

/**
 * Created by Ibitoye Olarewaju on 10/11/2017.
 */

public class CryptoAPI {
    public Bitcoin getBitcoin() {
        return mBitcoin;
    }

    public void setBitcoin(Bitcoin bitcoin) {
        this.mBitcoin = bitcoin;
    }

    private Bitcoin mBitcoin;

    public Ethereum getEthereum() {
        return mEthereum;
    }

    public void setEthereum(Ethereum ethereum) {
       this. mEthereum = ethereum;
    }

    private Ethereum mEthereum;
}
