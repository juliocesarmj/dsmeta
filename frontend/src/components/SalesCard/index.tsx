import NotificationButton from '../NotificationButton';
import './styles.css';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { useEffect, useState } from 'react';
import axios from 'axios';

type Sale = {
  id: number;
  sellerName: string;
  visited: number;
  deals: number;
  amount: number;
  date: Date;
};

const SalesCard = () => {
  const min = new Date(new Date().setDate(new Date().getDate() - 365));

  const [minDate, setMinDate] = useState(min);
  const [maxDate, setMaxDate] = useState(new Date());

  const [dados, setDados] = useState<Sale[]>([]);

  useEffect(() => {
    axios
      .get('https://dsmeta-juliomoraes.herokuapp.com/sales/salesperdate')
      .then(({ data }) => {
        // setDados(data);
        console.log(data);
      });
  }, []);

  return (
    <div className="dsmeta-card">
      <h2 className="dsmeta-sales-title">Vendas</h2>
      <div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={minDate}
            onChange={(date: Date) => setMinDate(date)}
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
        <div className="dsmeta-form-control-container">
          <DatePicker
            selected={maxDate}
            onChange={(date: Date) => setMaxDate(date)}
            className="dsmeta-form-control"
            dateFormat="dd/MM/yyyy"
          />
        </div>
      </div>

      <div>
        <table className="dsmeta-sales-table">
          <thead>
            <tr>
              <th className="show992">ID</th>
              <th className="show576">Data</th>
              <th>Vendedor</th>
              <th className="show992">Visitas</th>
              <th className="show992">Vendas</th>
              <th>Total</th>
              <th>Notificar</th>
            </tr>
          </thead>
          <tbody>
            {dados.map((d) => (
              <tr key={d.id}>
                <td className="show992">{d.id}</td>
                <td className="show576">{d.date.toDateString()}</td>
                <td>{d.sellerName}</td>
                <td className="show992">{d.visited}</td>
                <td className="show992">{d.deals}</td>
                <td>{d.amount}</td>
                <td>
                  <div className="dsmeta-red-btn-container">
                    <NotificationButton />
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default SalesCard;
