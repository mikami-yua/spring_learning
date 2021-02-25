package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.domain.Sale;
import org.example.excep.NotEnoughException;
import org.example.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    /**
     *rollbackFor:发生指定的异常一定回滚
     */
    /*@Transactional(
            propagation = Propagation.REQUIRED,//告诉spring传播行为为REQUIRED
            isolation = Isolation.DEFAULT,//默认隔离级别
            readOnly = false,
            rollbackFor = {//抛什么异常时进行回滚
                NullPointerException.class,//空指针异常混滚
                    NotEnoughException.class
            }
    )*/
    //都是用默认值时更简单的写法
    @Transactional//都使用事务控制的默认值，默认抛出运行时异常混滚事务
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("buy function start");
        //记录销售信息
        Sale sale=new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        //更新库存
        Goods goods=goodsDao.selectGoods(goodsId);
        if(goods==null){
            //商品不存在
            throw  new NullPointerException("No."+goodsId+"商品不存在");
        }else if(goods.getAmount()<nums){
            //商品库存不足
            throw new NotEnoughException("No."+goodsId+"商品库存不足");
        }
        //修改库存
        Goods buyGood=new Goods();
        buyGood.setId(goodsId);
        buyGood.setAmount(nums);
        goodsDao.updateGoods(buyGood);
        System.out.println("buy function start");
    }
}
