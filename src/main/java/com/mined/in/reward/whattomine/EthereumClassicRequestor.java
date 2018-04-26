package com.mined.in.reward.whattomine;

import java.math.BigDecimal;
import java.util.Date;

import com.mined.in.coin.CoinInfo;

import okhttp3.OkHttpClient;

/**
 * Requestor of ethereum classic estimated reward.
 *
 * @author Dmitry Tverdokhleb
 *
 */
class EthereumClassicRequestor extends Requestor {

    /** Base rewards is 84.0 MH/s. */
    private static final BigDecimal BASE_REWARD = BigDecimal.valueOf(84000000);
    /** Next update of estimated reward. */
    private static Date NEXT_UPDATE = new Date(0);
    /** Cached coin info. */
    private static CoinInfo COIN_INFO;
    /** Cached estimated reward per day. */
    private static BigDecimal ESTIMATED_REWARD_PER_DAY;
    /** API url. */
    private static final String API_URL = "https://whattomine.com/coins/162.json";

    /**
     * Creates the instance.
     *
     * @param httpClient HTTP client
     * @param endpointsUpdate endpoints update
     */
    EthereumClassicRequestor(OkHttpClient httpClient, int endpointsUpdate) {
        super(httpClient, endpointsUpdate);
    }

    @Override
    public BigDecimal getBaseReward() {
        return BASE_REWARD;
    }

    @Override
    public String getUrl() {
        return API_URL;
    }

    @Override
    public Date getCachedNextUpdate() {
        return NEXT_UPDATE;
    }

    @Override
    public void setCachedNextUpdate(Date nextUpdate) {
        NEXT_UPDATE = nextUpdate;
    }

    @Override
    public CoinInfo getCachedCoinInfo() {
        return COIN_INFO;
    }

    @Override
    public void setCachedCoinInfo(CoinInfo coinInfo) {
        COIN_INFO = coinInfo;
    }

    @Override
    public BigDecimal getCachedEstimatedRewardPerDay() {
        return ESTIMATED_REWARD_PER_DAY;
    }

    @Override
    public void setCachedEstimatedRewardPerDay(BigDecimal estimatedRewardPerDay) {
        ESTIMATED_REWARD_PER_DAY = estimatedRewardPerDay;
    }

}