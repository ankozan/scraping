import React, { useState, useEffect } from "react";
import Product from "./Product";
import products from "./data.json";

const ProductList = () => {
  const [items, setItems] = useState([]);

  useEffect(() => {
    setItems(products);
  }, []);

  return (
    <div>
      {items.map((item) => (
        <Product
          key={item.id}
          title={item.title}
          brand={item.brand}
          oldPrice={item.oldPrice}
          newPrice={item.newPrice}
          savingsPercentage={item.savingsPercentage}
          imageLink={item.imgLink}
        />
      ))}
    </div>
  );
};

export default ProductList;
