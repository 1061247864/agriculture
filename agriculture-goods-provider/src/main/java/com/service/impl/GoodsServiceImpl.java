package com.service.impl;

/*import java.io.IOException;*/
import java.util.ArrayList;
import java.util.List;
/*import java.util.Map;

import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.request.QueryRequest;*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.GoodTypeMapper;
import com.mapper.GoodsMapper;
import com.pojo.GoodType;
import com.pojo.Goods;
import com.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private GoodTypeMapper goodTypeMapper;

	@Override
	public List<Goods> show(Goods goods) {
		return goodsMapper.show(goods);
	}

	@Override
	public PageInfo<Goods> showGoods(Integer currentPage, Goods goods){
		/*
		 * SolrServer server = new HttpSolrServer("http://localhost:8080/solr/#/goods");
		 * SolrQuery query = new SolrQuery(); query.setQuery("*:*");
		 */
		/*
		 * if (goods.getGoodName() != null && goods.getGoodName() != "") {
		 * query.setQuery("name:" + goods.getGoodName() + ""); } if (goods.getShopId()
		 * != 0) { query.setQuery("shop_id:" + goods.getShopId() + ""); } if
		 * (goods.getCategorylevel1id() != 0) { query.setQuery("categoryLevel1Id:" +
		 * goods.getCategorylevel1id() + ""); } if (goods.getCategorylevel2id() != 0) {
		 * query.setQuery("categoryLevel2Id:" + goods.getCategorylevel2id() + ""); } if
		 * (goods.getCategorylevel3id() != 0) { query.setQuery("categoryLevel3Id:" +
		 * goods.getCategorylevel3id() + ""); }
		 */
		/*
		 * QueryResponse response; try { response = server.query(query);
		 * SolrDocumentList list = response.getResults(); List<Goods> findG = new
		 * ArrayList<Goods>(list.size()); Map<String, Map<String, List<String>>> maplist
		 * = response.getHighlighting(); for (SolrDocument doc : list) { Goods good =
		 * new Goods(); good.setGoodId(Integer.parseInt(doc.get("id").toString()));
		 * Map<String, List<String>> fieldMap = maplist.get(doc.get("id")); List<String>
		 * stringlist = fieldMap.get("custNames"); good.setGoodName(stringlist.get(0));
		 * good.setPrice(Double.parseDouble(doc.get("price").toString().replace("[",
		 * "").replace("]", "")));
		 * good.setContext(doc.get("context").toString().replace("[", "").replace("]",
		 * "")); findG.add(good); PageHelper.startPage(currentPage, 2); PageInfo<Goods>
		 * pageInfo = new PageInfo<>(findG); return pageInfo; }
		 * 
		 * } catch (SolrServerException e) { e.printStackTrace(); }
		 */
		PageHelper.startPage(currentPage, 2); 
		List<Goods> ggg=goodsMapper.show(goods);
		PageInfo<Goods> pageInfo = new PageInfo<>(ggg);
		 return pageInfo; 
		/*return null;*/
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
}
