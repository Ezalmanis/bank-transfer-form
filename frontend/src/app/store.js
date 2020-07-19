import { configureStore } from '@reduxjs/toolkit';
import paymentReducer from '../features/components/payments/reducers/paymentSlice';

export default configureStore({
  reducer: {
    payment: paymentReducer,
  },
});
