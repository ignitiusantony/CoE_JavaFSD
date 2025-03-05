import React, { createContext, useReducer } from 'react';

export const CartContext = createContext();

const cartReducer = (state, action) => {
  switch (action.type) {
    case 'ADD_TO_CART':
      const existingProductIndex = state.findIndex(item => item.id === action.product.id);
      if (existingProductIndex >= 0) {
        const updatedCart = [...state];
        updatedCart[existingProductIndex] = {
          ...updatedCart[existingProductIndex],
          quantity: updatedCart[existingProductIndex].quantity + 1
        };
        return updatedCart;
      } else {
        return [...state, { ...action.product, quantity: 1 }];
      }
    case 'REMOVE_FROM_CART':
      const productIndex = state.findIndex(item => item.id === action.product.id);
      if (state[productIndex].quantity > 1) {
        const updatedCart = [...state];
        updatedCart[productIndex] = {
          ...updatedCart[productIndex],
          quantity: updatedCart[productIndex].quantity - 1
        };
        return updatedCart;
      } else {
        return state.filter(item => item.id !== action.product.id);
      }
    default:
      return state;
  }
};

export const CartProvider = ({ children }) => {
  const [cart, dispatch] = useReducer(cartReducer, []);

  const addToCart = (product) => {
    dispatch({ type: 'ADD_TO_CART', product });
  };

  const removeFromCart = (product) => {
    dispatch({ type: 'REMOVE_FROM_CART', product });
  };

  return (
    <CartContext.Provider value={{ cart, addToCart, removeFromCart }}>
      {children}
    </CartContext.Provider>
  );
};
