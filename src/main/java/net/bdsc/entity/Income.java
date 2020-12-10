package net.bdsc.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Income extends BaseEntity<Long>{

    private Long userId;
    private int productId;
    private String productName;
    private int invest;
    private int frozenInvest;
    private int frozenInvestTemp;
    private BigDecimal allBtc;
    private BigDecimal allHpt;
    private int allEth;
    private int lastEth;
    private BigDecimal lastBtc;
    private BigDecimal lastHpt;
    private String lastTime;
    private String frozenTime;
    private String investTime;
    private BigDecimal returnMoney;
    private int returnDays;
    private String userName;
    private String phone;
    private boolean isExpire;
    private String validity;
    private BigDecimal allBtcPrice;
    private BigDecimal allHptPrice;
    private BigDecimal lastBtcPrice;
    private BigDecimal lastHptPrice;
    private BigDecimal allEthPrice;
    private BigDecimal lastEthPrice;
    private int type;
    private String profit;
    private String profitYear;
    private String electric;
    private String electricDiscount;
    private String manage;
    private String manageDiscount;
    private String btcDiscount;
    private String hbtDiscount;
    private String expireDate;
    private String comeDate;
    private String expirationDate;
    private int coinType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getInvest() {
        return invest;
    }

    public void setInvest(int invest) {
        this.invest = invest;
    }

    public int getFrozenInvest() {
        return frozenInvest;
    }

    public void setFrozenInvest(int frozenInvest) {
        this.frozenInvest = frozenInvest;
    }

    public int getFrozenInvestTemp() {
        return frozenInvestTemp;
    }

    public void setFrozenInvestTemp(int frozenInvestTemp) {
        this.frozenInvestTemp = frozenInvestTemp;
    }

    public BigDecimal getAllBtc() {
        return allBtc;
    }

    public void setAllBtc(BigDecimal allBtc) {
        this.allBtc = allBtc;
    }

    public BigDecimal getAllHpt() {
        return allHpt;
    }

    public void setAllHpt(BigDecimal allHpt) {
        this.allHpt = allHpt;
    }

    public int getAllEth() {
        return allEth;
    }

    public void setAllEth(int allEth) {
        this.allEth = allEth;
    }

    public int getLastEth() {
        return lastEth;
    }

    public void setLastEth(int lastEth) {
        this.lastEth = lastEth;
    }

    public BigDecimal getLastBtc() {
        return lastBtc;
    }

    public void setLastBtc(BigDecimal lastBtc) {
        this.lastBtc = lastBtc;
    }

    public BigDecimal getLastHpt() {
        return lastHpt;
    }

    public void setLastHpt(BigDecimal lastHpt) {
        this.lastHpt = lastHpt;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getFrozenTime() {
        return frozenTime;
    }

    public void setFrozenTime(String frozenTime) {
        this.frozenTime = frozenTime;
    }

    public String getInvestTime() {
        return investTime;
    }

    public void setInvestTime(String investTime) {
        this.investTime = investTime;
    }

    public BigDecimal getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(BigDecimal returnMoney) {
        this.returnMoney = returnMoney;
    }

    public int getReturnDays() {
        return returnDays;
    }

    public void setReturnDays(int returnDays) {
        this.returnDays = returnDays;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isExpire() {
        return isExpire;
    }

    public void setExpire(boolean expire) {
        isExpire = expire;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public BigDecimal getAllBtcPrice() {
        return allBtcPrice;
    }

    public void setAllBtcPrice(BigDecimal allBtcPrice) {
        this.allBtcPrice = allBtcPrice;
    }

    public BigDecimal getAllHptPrice() {
        return allHptPrice;
    }

    public void setAllHptPrice(BigDecimal allHptPrice) {
        this.allHptPrice = allHptPrice;
    }

    public BigDecimal getLastBtcPrice() {
        return lastBtcPrice;
    }

    public void setLastBtcPrice(BigDecimal lastBtcPrice) {
        this.lastBtcPrice = lastBtcPrice;
    }

    public BigDecimal getLastHptPrice() {
        return lastHptPrice;
    }

    public void setLastHptPrice(BigDecimal lastHptPrice) {
        this.lastHptPrice = lastHptPrice;
    }

    public BigDecimal getAllEthPrice() {
        return allEthPrice;
    }

    public void setAllEthPrice(BigDecimal allEthPrice) {
        this.allEthPrice = allEthPrice;
    }

    public BigDecimal getLastEthPrice() {
        return lastEthPrice;
    }

    public void setLastEthPrice(BigDecimal lastEthPrice) {
        this.lastEthPrice = lastEthPrice;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getProfitYear() {
        return profitYear;
    }

    public void setProfitYear(String profitYear) {
        this.profitYear = profitYear;
    }

    public String getElectric() {
        return electric;
    }

    public void setElectric(String electric) {
        this.electric = electric;
    }

    public String getElectricDiscount() {
        return electricDiscount;
    }

    public void setElectricDiscount(String electricDiscount) {
        this.electricDiscount = electricDiscount;
    }

    public String getManage() {
        return manage;
    }

    public void setManage(String manage) {
        this.manage = manage;
    }

    public String getManageDiscount() {
        return manageDiscount;
    }

    public void setManageDiscount(String manageDiscount) {
        this.manageDiscount = manageDiscount;
    }

    public String getBtcDiscount() {
        return btcDiscount;
    }

    public void setBtcDiscount(String btcDiscount) {
        this.btcDiscount = btcDiscount;
    }

    public String getHbtDiscount() {
        return hbtDiscount;
    }

    public void setHbtDiscount(String hbtDiscount) {
        this.hbtDiscount = hbtDiscount;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getComeDate() {
        return comeDate;
    }

    public void setComeDate(String comeDate) {
        this.comeDate = comeDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCoinType() {
        return coinType;
    }

    public void setCoinType(int coinType) {
        this.coinType = coinType;
    }
}
