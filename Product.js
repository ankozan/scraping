import React, { useState, useEffect } from "react";
import products from "./data.json";

const Product = ({
  title,
  brand,
  newPrice,
  oldPrice,
  savingsPercentage,
  imageLink,
}) => (
  <div>
    <h4>{brand}</h4>
    <h3>{title}</h3>
    <img src={imageLink} alt={imageLink} width="50" height="50"></img>
    <p>New Price: {newPrice}</p>
    <p>Old Price: {oldPrice}</p>
    <p>Savings: {savingsPercentage}</p>
  </div>
);

export default Product;
