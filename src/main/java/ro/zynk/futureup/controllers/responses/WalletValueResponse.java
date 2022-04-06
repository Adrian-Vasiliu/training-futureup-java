package ro.zynk.futureup.controllers.responses;

public class WalletValueResponse extends BaseResponse {
    private WalletResponse walletResponse;
    private Float valueOfWallet;

    public WalletValueResponse(WalletResponse walletResponse, float valueOfWallet) {
        this.walletResponse = walletResponse;
        this.valueOfWallet = valueOfWallet;
    }

    public WalletResponse getWalletResponse() {
        return walletResponse;
    }

    public void setWalletResponse(WalletResponse walletResponse) {
        this.walletResponse = walletResponse;
    }

    public float getValueOfWallet() {
        return valueOfWallet;
    }

    public void setValueOfWallet(float valueOfWallet) {
        this.valueOfWallet = valueOfWallet;
    }
}
