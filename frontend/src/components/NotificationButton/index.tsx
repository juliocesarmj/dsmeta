import axios from 'axios';
import { toast } from 'react-toastify';
import NotificationIcon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type Props = {
  saleId: number;
  name: string;
};
const NotificationButton = ({ saleId, name }: Props) => {
  function handleCLick(id: number) {
    axios
      .get(`${BASE_URL}/sales/${id}/notification`)
      .then((r) =>
        toast.success(
          'SMS para o vendedor ' + name + ' foi enviado com sucesso',
        ),
      );
  }

  return (
    <div className="dsmeta-red-btn" onClick={() => handleCLick(saleId)}>
      <img src={NotificationIcon} alt="Notificar" />
    </div>
  );
};
export default NotificationButton;
