import axios from 'axios';
import NotificationIcon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type Props = {
  saleId: number;
};
const NotificationButton = ({ saleId }: Props) => {
  function handleCLick(id: number) {
    axios.get(`${BASE_URL}/sales/${id}/notification`).then();
  }

  return (
    <div className="dsmeta-red-btn" onClick={() => handleCLick(saleId)}>
      <img src={NotificationIcon} alt="Notificar" />
    </div>
  );
};
export default NotificationButton;
