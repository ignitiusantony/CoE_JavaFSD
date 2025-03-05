import React, { useContext } from 'react';
import { CartContext } from '../context/CartContext';
import styled from 'styled-components';

function Cart() {
  const { cart, removeFromCart } = useContext(CartContext);

  const totalPrice = cart.reduce((total, product) => total + product.price * product.quantity, 0);

  return (
    <StyledContainer>
      <h1>Cart Page</h1>
      <CartList>
        {cart.map((product, index) => (
          <StyledWrapper key={index}>
            <div className="card">
              <div className="container">
                <div className="left">
                  <div className="status-ind" />
                </div>
                <div className="right">
                  <div className="text-wrap">
                    <p className="text-content">
                      <a className="text-link" href="#">{product.name}</a>
                    </p>
                    <p className="time">Price: ₹{product.price}</p>
                    <p className="time">Quantity: {product.quantity}</p>
                  </div>
                  <div className="button-wrap">
                    <button className="primary-cta" onClick={() => removeFromCart(product)}>Remove from Cart</button>
                  </div>
                </div>
              </div>
            </div>
          </StyledWrapper>
        ))}
      </CartList>
      <TotalPrice>Total Price: ₹{totalPrice}</TotalPrice>
    </StyledContainer>
  );
}

const StyledContainer = styled.div`
  padding: 2em;
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  background-color: lightblue;
`;

const CartList = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 2em;
`;

const StyledWrapper = styled.div`
  .card {
    width: fit-content;
    background-color: #f2f3f7;
    border-radius: 0.75em;
    cursor: pointer;
    transition: ease 0.2s;
    box-shadow: 1em 1em 1em #d8dae0b1, -0.75em -0.75em 1em #ffffff;
    border: 1.5px solid #f2f3f7;
  }

  .card:hover {
    background-color: #d3ddf1;
    border: 1.5px solid #1677ff;
  }

  .container {
    margin-top: 1.25em;
    margin-bottom: 1.375em;
    margin-left: 1.375em;
    margin-right: 2em;
    display: flex;
    flex-direction: row;
    gap: 0.75em;
  }

  .status-ind {
    width: 0.625em;
    height: 0.625em;
    background-color: #ff0000;
    margin: 0.375em 0;
    border-radius: 0.5em;
  }

  .text-wrap {
    display: flex;
    flex-direction: column;
    gap: 0.25em;
    color: #333;
  }

  .time {
    font-size: 0.875em;
    color: #777;
  }

  .text-link {
    font-weight: 500;
    text-decoration: none;
    color: black;
  }

  .button-wrap {
    display: flex;
    flex-direction: row;
    gap: 1em;
    align-items: center;
  }

  .secondary-cta {
    background-color: transparent;
    border: none;
    font-size: 15px;
    font-weight: 400;
    color: #666;
    cursor: pointer;
  }

  .primary-cta {
    font-size: 15px;
    background-color: transparent;
    font-weight: 600;
    color: #1677ff;
    border: none;
    border-radius: 1.5em;
    cursor: pointer;
  }

  button:hover {
    text-decoration: underline;
  }

  .right {
    display: flex;
    flex-direction: column;
    gap: 0.875em;
  }
`;

const TotalPrice = styled.h2`
  margin-top: auto;
  text-align: center;
  padding: 1em;
  background-color: lightblue;
  border-top: 1px solid #d8dae0;
`;

export default Cart;
