package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.mapper.GoodTypeMapper;
import com.mapper.GoodsMapper;
import com.mapper.ShopMapper;
import com.pojo.GoodType;
import com.pojo.Goods;
import com.pojo.Shop;
import com.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private ShopMapper shopMapper;

	@Autowired
	private GoodTypeMapper goodTypeMapper;

	@Override
	public PageInfo<Goods> showGoods(Integer currentPage, Goods goods) {
		SolrServer server = new HttpSolrServer("http://localhost:8080/solr/goods");
		SolrQuery query = new SolrQuery();
		StringBuilder queryString = new StringBuilder();
		if (goods != null) {

			if (goods.getGoodName() != null && !"".equals(goods.getGoodName())) {
				queryString.append("     AND  goodname:" + goods.getGoodName() + "    ");
			}
			if (goods.getShopId() != null && goods.getShopId() != 0) {
				queryString.append("     AND  shop_id:" + goods.getShopId() + "    ");
			}

			if (goods.getCategorylevel1id() != null && goods.getCategorylevel1id() != 0) {
				queryString.append("     AND   categoryLevel1Id:" + goods.getCategorylevel1id() + "    ");
			} else if (goods.getCategorylevel2id() != null && goods.getCategorylevel2id() != 0) {
				queryString.append("       AND  categoryLevel2Id:" + goods.getCategorylevel2id() + "    ");
			} else if (goods.getCategorylevel3id() != null && goods.getCategorylevel3id() != 0) {
				queryString.append("      AND   categoryLevel3Id:" + goods.getCategorylevel3id() + "    ");
			}
			if (StringUtil.isEmpty(queryString.toString())) {
				query.setQuery("*:*");
			} else {
				query.setQuery(queryString.toString().substring(queryString.toString().indexOf("AND") + 3,
						queryString.toString().length()));
			}

		} else {
			query.setQuery("*:*");
		}
		List<Goods> findG = null;
		try {
			SolrDocumentList docs = server.query(query).getResults();
			findG = new ArrayList<Goods>(docs.size());
			for (SolrDocument doc : docs) {
				Goods good = new Goods();
				good.setGoodId(Integer.parseInt((String) doc.getFieldValue("id")));
				good.setGoodName(doc.getFieldValue("goodname").toString());
				good.setStatus(Integer.parseInt((String) doc.getFieldValue("status")));
				good.setPrice(Double.parseDouble((String) doc.getFieldValue("goodprice")));
				good.setCompany(doc.getFieldValue("company").toString());
				good.setContext(doc.getFieldValue("context").toString());
				good.setSum(Integer.parseInt((String) doc.getFieldValue("sum")));
				good.setSumBack(Integer.parseInt((String) doc.getFieldValue("sum_back")));
				good.setShopId(Integer.parseInt((String) doc.getFieldValue("shop_id")));
				good.setCategorylevel1id(Integer.parseInt((String) doc.getFieldValue("categoryLevel1Id")));
				good.setCategorylevel2id(Integer.parseInt((String) doc.getFieldValue("categoryLevel2Id")));
				good.setCategorylevel3id(Integer.parseInt((String) doc.getFieldValue("categoryLevel3Id")));
				good.setPhoto(doc.getFieldValue("photo").toString());
				findG.add(good);
			}

		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		PageHelper.startPage(currentPage, 2);
		PageInfo<Goods> pageInfo = new PageInfo<>(findG);
		return pageInfo;
	}

	@Override
	public int insert(Goods goods) {
		return goodsMapper.insert(goods);
	}

	@Override
	public int del(Integer goodsid) {
		return goodsMapper.del(goodsid);
	}

	@Override
	public int update(Goods goods) {
		return goodsMapper.update(goods);
	}

	@Override
	public List<GoodType> getGoodTypeList() {
		List<GoodType> list = goodTypeMapper.show(null);
		for (GoodType goodType : list) {

			List<GoodType> list2 = goodTypeMapper.show(goodType);
			goodType.setGoodTypeList(list2);

			for (GoodType goodType2 : list2) {
				List<GoodType> list3 = goodTypeMapper.show(goodType2);
				goodType2.setGoodTypeList(list3);
			}
		}
		return list;
	}

	@Override
	public List<Shop> showShops(Shop shop) {
		return shopMapper.show(shop);
	}
}
